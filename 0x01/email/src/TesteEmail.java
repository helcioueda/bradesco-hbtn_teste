import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesteEmail {

    @Test
    void testar_email_com_arroba() {
        assertTrue(Pessoa.emailValid("email_teste@dominio.com.br"),
                   "O e-mail com '@' deve ser válido.");
    }

    @Test
    void testar_email_sem_arroba() {
        assertFalse(Pessoa.emailValid("email_testedominio.com.br"),
                    "O e-mail sem '@' deve ser inválido.");
    }

    @Test
    void testar_email_mais_50_caracteres() {
        String emailLongo = "email_teste_muito_longo_nao_deve_ser_valido@dominio.com.br";
        assertEquals(false, Pessoa.emailValid(emailLongo),
                     "O e-mail com mais de 50 caracteres deve ser inválido.");
    }
}