package com.practice.in.DesignPatterns;


//Builder Pattern for Object Construction
public class Builder_Pattern_Tester {
	
	public static void main(String[]args) {
		Email email = new Email.EmailBuilder().
					setFrom("judgeboyz01@gmail.com").
					setTo("mrarshjudge@gmail.com").
					setSubject("Testing Email").
					setContent("Hi This is my Testing Email").
					setPostMessage("Email is ended").
					build();
		System.out.println(email.toString());
	}
}

class Email{
	private final String from;
	private final String to;
	private final String subject;
	private final String content;
	private final String postMessage;
	
	public Email(EmailBuilder builder) {
		this.from= builder.from;
		this.to = builder.to;
		this.subject = builder.subject;
		this.content = builder.content;
		this.postMessage = builder.postMessage;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Sending email to: ");
		if(!to.isEmpty())  sb.append(to);
		
		sb.append(" from :");
		if(!from.isEmpty()) sb.append(from);
		
		sb.append(" with subject: ");
		if(!subject.isEmpty()) sb.append(subject);
		
		sb.append(" and content is: ");
		if(!content.isEmpty()) sb.append(content);
		
		sb.append(" and Post Message is ");
		if(!postMessage.isEmpty()) sb.append(postMessage);
		
		return sb.toString();
	}
	
	static class EmailBuilder{
		String from;
		String to;
		String subject;
		String content;
		String postMessage;
		
		public  EmailBuilder setFrom(String from) {
			this.from = from ;
			return this;
		}
		
		public EmailBuilder setTo(String to) {
			this.to =to;
			return this;
		}
		public EmailBuilder setSubject(String subject) {
			this.subject = subject ;
			return this;
		}
		public EmailBuilder setContent(String content) {
			this.content = content;
			return this;
		}
		public EmailBuilder setPostMessage(String postMessage) {
			this.postMessage = postMessage;
			return this;
		}
		public Email build() {
			return new Email(this);
		}
	}
}
