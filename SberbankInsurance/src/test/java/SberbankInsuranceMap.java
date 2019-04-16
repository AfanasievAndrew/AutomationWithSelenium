
public class SberbankInsuranceMap
{
    public Person Person = new Person();

    public TravelShopping TravelShopping = new TravelShopping();

    public TravelInsurance TravelInsurance = new TravelInsurance();

    public class Person
    {
        public String InsuranceMenu = "//button[@aria-label='Меню Страхование']";

        public String InsuranceSubMenu = "//div[@class='lg-menu__sub']//a[text()='Путешествия и покупки']";
    }

    public class TravelShopping
    {
        public String InsuranceLabel = "//h3[text()='Страхование путешественников']";

        public String CheckoutOnlineButton = "//h3[text()='Страхование путешественников']" +
                "/ancestor::div[contains(@class,'bp-container')][position() = 1]//a[text()='Оформить онлайн']";
    }

    public class TravelInsurance
    {
        public SelectPolicyTab SelectPolicyTab = new SelectPolicyTab();

        public RegistrationTab RegistrationTab = new RegistrationTab();

        public class SelectPolicyTab
        {
            public String TabLabel = "//*[text()='Выбор полиса']";

            public String MinimalPolicy = "//div[contains(text(),'Минимальная')]/parent::div";

            public String RegistrationButton = "//form//*[text()='Оформить']";
        }

        public class RegistrationTab
        {
            public String InsuredSurname= "insured0_surname";
            public String InsuredName= "insured0_name";
            public String InsuredBirthDate= "insured0_birthDate";

            public String Surname= "surname";
            public String Name= "name";
            public String Middlename= "middlename";
            public String BirthDate= "birthDate";
            public String PassportSeries= "passport_series";
            public String PassportNumber= "passport_number";
            public String IssueDate= "issueDate";
            public String IssuePlace= "issuePlace";
            public String NextButton= "//*[text()='Продолжить']";

            private String WarningMessage = "Заполнены не все обязательные поля";

            public String WarningLabel= "//div[contains(@class,'form-error-message')]"
                    + "/child::div[text()='"
                    + WarningMessage
                    + "'][not (contains(@class,'ng-hide'))]";
        }
    }
}
