package zw.co.zetdc.enums;

public enum District {
//    EAST_DISTRICT,
//    NORTH_DISTRICT,
//    SOUTH_DISTRICT,
//    CHITUNGWIZA_DISTRICT,
//    CHINHOYI_DISTRICT,
//    BINDURA_DISTRICT,
//    KADOMA_DISTRICT,
//    MARONDERA_DISTRICT,
//    HARARE_ENVIRONS,
//    GWERU_DISTRICT,
//    KWEKWE_DISTRICT,
//    MUTARE_DISTRICT,
//    MANICALAND_DISTRICT,
//    MASVINGO_DISTRICT,
//
//    BULAWAYO_RURAL_DISTRICT,
//
//    BYO_WEST_DISTRICT,
//    BYO_EAST_DISTRICT


    NO_DISTRICT(Region.NO_REGION),
    EAST_DISTRICT(Region.EASTERN_REGION),
    NORTH_DISTRICT(Region.HARARE_REGION),
    GWERU_DISTRICT(Region.WESTERN_REGION),
    KWEKWE_DISTRICT(Region.HEAD_OFFICE);

    private final Region region;

    District(Region region) {
        this.region = region;
    }

    public Region getRegion() {
        return region;
    }

}
