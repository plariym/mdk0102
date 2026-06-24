import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class EmailMessageTest {

    private EmailMessage email;

    @BeforeAll
    static void initTotalEmailsSent() {
        EmailMessage.totalEmailsSent = 0;
        System.out.println("Инициализация общего счётчика: totalEmailsSent = 0");
    }

    @BeforeEach
    void setUp() {
        email = new EmailMessage("ivan@mail.ru", "petr@mail.ru");
        System.out.println("Создано новое письмо от ivan@mail.ru для petr@mail.ru");
    }

    // Задание 1
    @Test
    void testEmailNotSentInitially() {
        assertFalse(email.isSent(), "Письмо не должно быть отправлено после создания");
    }

    // Задание 2
    @Test
    void testSendFilledEmail() {
        email.setSubject("Привет");
        email.setBody("Как дела?");

        boolean result = email.send();

        assertTrue(result, "Отправка заполненного письма должна вернуть true");
        assertTrue(email.isSent(), "После отправки sent должен стать true");
    }

    @Test
    void testSendEmailWithEmptySender() {
        EmailMessage emptySenderEmail = new EmailMessage("", "petr@mail.ru");
        emptySenderEmail.setSubject("Тест");
        emptySenderEmail.setBody("Тестовое сообщение");

        boolean result = emptySenderEmail.send();

        assertFalse(result, "Отправка письма с пустым отправителем должна вернуть false");
        assertFalse(emptySenderEmail.isSent(), "Письмо не должно быть отправлено");
    }

    //Задание 3
    @Test
    @DisplayName("Отправка нескольких писем и проверка счётчика")
    void testMultipleEmailsAndCounter() {
        int initialCount = EmailMessage.totalEmailsSent;

        EmailMessage email1 = new EmailMessage("a@mail.ru", "b@mail.ru");
        email1.setSubject("Тема 1");
        email1.setBody("Тело 1");
        boolean sent1 = email1.send();
        assertTrue(sent1, "Первое письмо должно отправиться");

        EmailMessage email2 = new EmailMessage("c@mail.ru", "d@mail.ru");
        email2.setSubject("Тема 2");
        email2.setBody("Тело 2");
        boolean sent2 = email2.send();
        assertTrue(sent2, "Второе письмо должно отправиться");

        EmailMessage email3 = new EmailMessage("e@mail.ru", "f@mail.ru");
        email3.setSubject("Тема 3");
        email3.setBody("Тело 3");
        boolean sent3 = email3.send();
        assertTrue(sent3, "Третье письмо должно отправиться");

        assertEquals(initialCount + 3, EmailMessage.totalEmailsSent,
                "После отправки 3 писем счётчик должен увеличиться на 3");
    }

    @Test
    @DisplayName("Отправка письма с пустым получателем")
    void testSendEmailWithEmptyRecipient() {
        EmailMessage emptyRecipientEmail = new EmailMessage("ivan@mail.ru", "");
        emptyRecipientEmail.setSubject("Тест");
        emptyRecipientEmail.setBody("Тестовое сообщение");

        boolean result = emptyRecipientEmail.send();

        assertFalse(result, "Отправка письма с пустым получателем должна вернуть false");
        assertFalse(emptyRecipientEmail.isSent(), "Письмо не должно быть отправлено");
        
    }

    @AfterEach
    void logTotalEmailsSent(TestInfo testInfo) {
        System.out.println("После теста \"" + testInfo.getDisplayName() +
                "\" totalEmailsSent = " + EmailMessage.totalEmailsSent);
    }

    @AfterAll
    static void printTotalEmailsSent() {
        System.out.println("Общее количество отправленных писем за все тесты: " +
                EmailMessage.totalEmailsSent);
    }
}