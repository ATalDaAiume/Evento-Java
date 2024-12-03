public class Notificacao {
    String mensagem;
    Pessoa destinatario;

    public Notificacao(String mensagem, Pessoa destinatario) {
        this.mensagem = mensagem;
        this.destinatario = destinatario;
    }

    // Envia uma notificação para o e-mail do destinatário
    public void notificarEmail() {
        if (destinatario instanceof Organizador) {
            Organizador organizador = (Organizador) destinatario;
            System.out.println("Enviando e-mail para: " + organizador.email);
            System.out.println("Mensagem: " + mensagem);
            // Aqui você integraria com a API de e-mail (JavaMail ou outra)
        } else if (destinatario instanceof Participante) {
            Participante participante = (Participante) destinatario;
            System.out.println("Enviando e-mail para: " + participante.email);
            System.out.println("Mensagem: " + mensagem);
            // Aqui você integraria com a API de e-mail
        }
    }

    // Envia uma notificação por telefone (SMS)
    public void notificarTelefone() {
        if (destinatario instanceof Organizador) {
            Organizador organizador = (Organizador) destinatario;
            System.out.println("Enviando SMS para: " + organizador.telefone);
            System.out.println("Mensagem: " + mensagem);
            // Aqui você integraria com a API de SMS (como Twilio)
        } else if (destinatario instanceof Participante) {
            Participante participante = (Participante) destinatario;
            System.out.println("Enviando SMS para: " + participante.telefone);
            System.out.println("Mensagem: " + mensagem);
            // Aqui você integraria com a API de SMS
        }
    }

    // Envia a notificação dependendo do tipo (email ou telefone)
    public void enviar() {
        notificarEmail();
        notificarTelefone();
    }
}
