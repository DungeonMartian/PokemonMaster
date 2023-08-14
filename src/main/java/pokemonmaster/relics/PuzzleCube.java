package pokemonmaster.relics;

//public class PuzzleCube extends BaseRelic implements CustomSavable<String> {
//    private static final String NAME = "FirstEdition"; //The name will be used for determining the image file as well as the ID.
//    public static final String ID = makeID(NAME); //This adds the mod's prefix to the relic ID, resulting in modID:MyRelic
//    private static final RelicTier RARITY = RelicTier.RARE; //The relic's rarity.
//    private static final LandingSound SOUND = LandingSound.FLAT; //The sound played when the relic is clicked.
//
//
//
//    public AbstractPlayer.PlayerClass chosenClass = null;
//
//    private boolean pickCard = false;
//
//    private Map<AbstractCard.CardRarity, CardGroup> chosenPools = null;
//    public PuzzleCube() {
//        super(ID, NAME, PokemonMaster.Enums.CARD_COLOR, RARITY, SOUND);
//
//    }
//
//
//
//    public String getUpdatedDescription() {
//        if (this.chosenClass == null)
//            return this.DESCRIPTIONS[0] + this.DESCRIPTIONS[1];
//        return this.DESCRIPTIONS[0] + chosenClassName() + this.DESCRIPTIONS[2];
//    }
//
//    public String onSave() {
//        if (this.chosenClass == null) {
//            return null;
//        }
//        return this.chosenClass.name();
//    }
//
//    public void onLoad(String playerClass) {
//        if (playerClass == null)
//            return;
//        System.out.println(playerClass);
//        System.out.println(AbstractPlayer.PlayerClass.valueOf(playerClass));
//        if (!chooseClass(AbstractPlayer.PlayerClass.valueOf(playerClass)))
//            System.out.println("OH GOD WTF!!");
//    }
//
//    private String chosenClassName() {
//        AbstractPlayer character = BaseMod.findCharacter(this.chosenClass);
//        return BaseMod.colorString(character.getLocalizedCharacterName(), "#" + character.getCardRenderColor().toString());
//    }
//
//    public void onEquip() {
//        flash();
//        this.pickCard = true;
//        CardGroup group = new CardGroup(CardGroup.CardGroupType.UNSPECIFIED);
//        for (AbstractPlayer character : CardCrawlGame.characterManager.getAllCharacters()) {
//            if (character.chosenClass != AbstractDungeon.player.chosenClass)
//                group.addToTop((AbstractCard)new DisguiseKitOption(character.chosenClass));
//        }
//        AbstractDungeon.gridSelectScreen.open(group, 1, "", false);
//    }
//
//    public void update() {
//        super.update();
//        if (this.pickCard && !AbstractDungeon.gridSelectScreen.selectedCards.isEmpty()) {
//            this.pickCard = false;
//            DisguiseKitOption selected = (DisguiseKitOption) AbstractDungeon.gridSelectScreen.selectedCards.get(0);
//            AbstractDungeon.gridSelectScreen.selectedCards.clear();
//            chooseClass(selected.chosenClass);
//        }
//    }
//
//    private boolean chooseClass(AbstractPlayer.PlayerClass chosenClass) {
//        AbstractCard.CardColor color;
//        this.chosenClass = chosenClass;
//        if (chosenClass == null) {
//            if (CardCrawlGame.dungeon == null)
//                System.out.println("dungeon null");
//            return false;
//        }
//        this.description = getUpdatedDescription();
//        this.tips.clear();
//        this.tips.add(new PowerTip(this.name, this.description));
//        initializeTips();
//        ArrayList<AbstractCard> tmpPool = new ArrayList<>();
//        switch (chosenClass) {
//            case IRONCLAD:
//                CardLibrary.addRedCards(tmpPool);
//                break;
//            case THE_SILENT:
//                CardLibrary.addGreenCards(tmpPool);
//                break;
//            case DEFECT:
//                CardLibrary.addBlueCards(tmpPool);
//                break;
//            default:
//                color = BaseMod.findCharacter(chosenClass).getCardColor();
//                for (Map.Entry<String, AbstractCard> c : (Iterable<Map.Entry<String, AbstractCard>>)CardLibrary.cards.entrySet()) {
//                    AbstractCard card = c.getValue();
//                    if (card.color.equals(color) && card.rarity != AbstractCard.CardRarity.BASIC && (
//                            !UnlockTracker.isCardLocked(c.getKey()) || Settings.isDailyRun))
//                        tmpPool.add(card);
//                }
//                break;
//        }
//        this.chosenPools = new HashMap<>();
//        for (AbstractCard c : tmpPool) {
//            if (!this.chosenPools.containsKey(c.rarity))
//                this.chosenPools.put(c.rarity, new CardGroup(CardGroup.CardGroupType.CARD_POOL));
//            ((CardGroup)this.chosenPools.get(c.rarity)).addToTop(c);
//        }
//        return true;
//    }
//
//    public AbstractCard getRewardCard(AbstractCard.CardRarity rarity) {
//        if (this.chosenPools == null)
//            return null;
//        if (this.chosenPools.containsKey(rarity))
//            return (this.chosenPools.get(rarity)).getRandomCard(true);
//        return null;
//    }
//
//    public AbstractRelic makeCopy() {
//        return (AbstractRelic)new PuzzleCube();
//    }
//}
//
//
//// Take advantage of autocomplete!
//    // If you type "public onUse" IntelliJ should already have the method in the suggestions.
//    // Use the up/down arrows to select it and press enter to automatically create this whole chunk.
//    // This autocomplete is also a good way to see all the hooks/look for the right hook by name, by just typing "publi"
//