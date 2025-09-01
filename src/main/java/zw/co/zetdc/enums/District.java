package zw.co.zetdc.enums;

public enum District {

    NO_DISTRICT(Region.NO_REGION),
    EAST(Region.HARARE),
    NORTH(Region.HARARE),
    SOUTH(Region.SOUTHERN),
    CHITUNGWIZA(Region.HEAD_OFFICE),
    CHINHOYI(Region.WESTERN),
    BINDURA(Region.HEAD_OFFICE),
    KADOMA(Region.HEAD_OFFICE),
    MARONDERA(Region.NCC),
    HARARE(Region.HEAD_OFFICE),
    GWERU(Region.WESTERN),
    KWEKWE(Region.SOUTHERN),
    MUTARE(Region.EASTERN),
    MANICALAND(Region.NORTHERN),
    MASVINGO(Region.EASTERN),
    BULAWAYO(Region.WESTERN),
    BULAWAYO_WEST(Region.WESTERN),
    BULAWAYO_EAST(Region.WESTERN),
    GWANDA(Region.WESTERN)
    ;


    private final Region region;

    District(Region region) {
        this.region = region;
    }

    public Region getRegion() {
        return region;
    }

}
