package domain;

public class DungeonClass implements IPWClass {
    private String nameTemplate;
    private String name;
    private String size;
    private int rooms;
    private int themesAmount;
    private String[] themes;
    private String themePrompt;
    private String form;
    private String exits;
    private String situation;
    private String accessibility;
    private String builder;
    private String function;
    private String causeOfRuin;
    private DiscoveryClass[] discoveries;
    private DangerClass[] dangers;
    private DungeonAreaClass[] areas;
    private String oneLiner;

    @Override
    public String getOneLiner(){
        return oneLiner;
    }
    @Override
    public void setOneLiner(String oneLiner) {
        this.oneLiner = oneLiner;
    }


    public void initializeDiscoveriesList(int i){
        this.discoveries = new DiscoveryClass[i];
    }

    public void addDiscovery(DiscoveryClass discovery){
        int i;
        for (i=0;i<this.discoveries.length;i++){
            if (this.discoveries[i]==null){
                this.discoveries[i]=discovery;
                break;
            }
        }
    }

    public void initializeDangersList(int i){
        this.dangers = new DangerClass[i];
    }

    public void addTheme(String theme){
        int i;
        for (i=0;i<this.themes.length;i++){
            if (this.themes[i]==null){
                this.themes[i]=theme;
                break;
            }
        }
    }

    public void initializeThemes(int i){
        this.themes = new String[i];
    }

    public void addArea(DungeonAreaClass area){
        int i;
        for (i=0;i<this.areas.length;i++){
            if (this.areas[i]==null){
                this.areas[i]=area;
                break;
            }
        }
    }

    public void initializeAreas(int i){
        this.areas = new DungeonAreaClass[i];
    }

    public void addDanger(DangerClass danger){
        int i;
        for (i=0;i<this.dangers.length;i++){
            if (this.dangers[i]==null){
                this.dangers[i]=danger;
                break;
            }
        }
    }


    public String getNameTemplate() {
        return nameTemplate;
    }

    public void setNameTemplate(String nameTemplate) {
        this.nameTemplate = nameTemplate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

        public String getThemePrompt() {
        return themePrompt;
    }

    public void setThemePrompt(String themePrompt) {
        this.themePrompt = themePrompt;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(String accessibility) {
        this.accessibility = accessibility;
    }

    public String getBuilder() {
        return builder;
    }

    public void setBuilder(String builder) {
        this.builder = builder;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getCauseOfRuin() {
        return causeOfRuin;
    }

    public void setCauseOfRuin(String causeOfRuin) {
        this.causeOfRuin = causeOfRuin;
    }


    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getThemesAmount() {
        return themesAmount;
    }

    public void setThemesAmount(int themesAmount) {
        this.themesAmount = themesAmount;
    }

        public String getExits() {
        return exits;
    }

    public void setExits(String exits) {
        this.exits = exits;
    }

    public String getThemes() {
        int i;
        String themesSTring = "";
        for (i=0;i<this.themes.length;i++){
            if (i==0){
                themesSTring+=themes[i];
            } else if (i<this.themes.length-1 && this.themes[i]!=null){
                themesSTring+= ", "+themes[i];
            } else if (i==this.themes.length-1 && this.themes[i]!=null){
                themesSTring+= " and "+themes[i];
            }
        }
        return themesSTring;
    }

    public void setThemes(String[] themes) {
        this.themes = themes;
    }

    public DiscoveryClass[] getDiscoveries() {
        return discoveries;
    }

    public void setDiscoveries(DiscoveryClass[] discoveries) {
        this.discoveries = discoveries;
    }

    public DangerClass[] getDangers() {
        return dangers;
    }

    public void setDangers(DangerClass[] dangers) {
        this.dangers = dangers;
    }

    public DungeonAreaClass[] getAreas() {
        return areas;
    }

    public void setAreas(DungeonAreaClass[] areas) {
        this.areas = areas;
    }

    @Override
    public String toString(){
        String str = String.format("""
             *** %s ***
             
             Size: %s
             Rooms: %s
             Theme amount: %d
             Themes: %s
             Form: %s
             Exits: %s
             Situation: %s
             Accessibility: %s
             Builder: %s
             Function: %s
             Cause of ruin: %s
             """,this.name.toUpperCase(), this.size, this.rooms,this.themesAmount, this.getThemes(), this.form,this.exits, this.situation, this.accessibility,this.builder, this.function, this.causeOfRuin);
        if (this.getAreas()[0]!=null){
            str+=String.format("\n\nDUNGEON AREAS:");
            int areaNumber =1 ;
            for(DungeonAreaClass a: this.getAreas()){
                str+=String.format("\nAREA %d:\n%s",areaNumber,a);
                areaNumber++;
            }
        }
     return str;
    }
}
