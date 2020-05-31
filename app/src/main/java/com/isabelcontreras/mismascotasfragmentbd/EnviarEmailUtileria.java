package com.isabelcontreras.mismascotasfragmentbd;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnviarEmailUtileria {

   public static String enviarCorreo(String nombre, String destino, String mensaje){
       Properties props = new Properties();
       props.put("mail.smtp.auth", "true");
       props.put("mail.smtp.starttls.enable", "true");
       props.put("mail.smtp.host", "smtp.gmail.com");
       props.put("mail.smtp.port", "587");
       String mensajeCorreo=null;
       mensajeCorreo="Estimado(a) "+nombre;
       mensajeCorreo+=", su mensaje: \n "+mensaje;
       mensajeCorreo+="\n ha sido enviado, muchas gracias por sus comentarios. ";
       try {
           Session session = Session.getInstance(props,
               new javax.mail.Authenticator() {
                   protected PasswordAuthentication getPasswordAuthentication() {
                       return new PasswordAuthentication("usuario@gmail.com", "1qASW#EDFR$%TG");
                   }
           });
           Message message = new MimeMessage(session);
           message.setFrom(new InternetAddress("usuario@gmail.com"));
           message.setRecipients(Message.RecipientType.TO,
                   InternetAddress.parse(destino));
           message.setSubject("MIS MASCOTAS");

           message.setText(mensajeCorreo);
           Transport.send(message);
       } catch (MessagingException e) {
           e.printStackTrace();
       }
       return mensajeCorreo;
   }

}
