package com.kodilla.good.patterns.challenges;

public final class WebsiteService implements InformationService
{
    private final String informationServiceType;

    public WebsiteService()
    {
        this.informationServiceType = "Website information service";
    }
    @Override
    public void inform(Customer user, String information)
    {
        System.out.println("Dear " + user.getFirstName() + ", " + information);
    }

    public String getInformationServiceType()
    {
        return this.informationServiceType;
    }
}
