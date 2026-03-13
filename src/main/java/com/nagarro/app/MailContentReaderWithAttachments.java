package com.nagarro.app;

import jakarta.mail.*;
import jakarta.mail.internet.MimeBodyPart;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;

public class MailContentReaderWithAttachments {

	public static void main(String[] args) throws Exception {
		String host = "imap.gmail.com";
		String username = "tester3815@gmail.com";
		String password = "ihvk tiaq djts iwpj";

		Properties props = new Properties();
		props.put("mail.store.protocol", "imaps");

		Session session = Session.getInstance(props);
		Store store = session.getStore();
		store.connect(host, username, password);

		Folder inbox = store.getFolder("INBOX");
		inbox.open(Folder.READ_ONLY);

		for (Message message : inbox.getMessages()) {
			System.out.println("Subject: " + message.getSubject());
			System.out.println("From: " + message.getFrom()[0]);
			System.out.println("Sent Date: " + message.getSentDate());

			Object content = message.getContent();
			if (content instanceof String) {
				System.out.println("Body: " + content);
			} else if (content instanceof Multipart) {
				Multipart multipart = (Multipart) content;
				for (int i = 0; i < multipart.getCount(); i++) {
					BodyPart part = multipart.getBodyPart(i);

					// Print plain text body
					if (part.isMimeType("text/plain")) {
						System.out.println("Body: " + part.getContent());
					}

					// Save attachments
					if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition()) || part.getFileName() != null) {
						String fileName = part.getFileName();
						File file = new File("downloads/" + fileName);
						file.getParentFile().mkdirs(); // Ensure directory exists

						((MimeBodyPart) part).saveFile(file);
						System.out.println("Downloaded attachment: " + fileName);
					}
				}
			}

			System.out.println("--------------------------------------------------");
		}

		inbox.close(false);
		store.close();
	}
}