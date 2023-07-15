package pokemonmaster.cards.Metal;

import com.megacrit.cardcrawl.actions.watcher.ChooseOneAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.cards.ChoiceCards.Dredge;
import pokemonmaster.cards.ChoiceCards.MachClaw;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import java.util.ArrayList;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Excadrill extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Excadrill",
            2,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);
    private static final int DAMAGE = 8;


    public Excadrill() {
        super(cardInfo);
        setDamage(DAMAGE);
        setCostUpgrade(1);
        tags.add(CustomTags.METAL);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.EVOLVED);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillMetal.png","pokemonmaster/character/cardback/bg_skillMetal_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {


        ArrayList<AbstractCard> ATTACKA = new ArrayList<>();
        ATTACKA.add(new Dredge());
        MachClaw machClaw = new MachClaw();
        machClaw.calculateCardDamage(m);
        ATTACKA.add(machClaw);
        addToBot(new ChooseOneAction(ATTACKA));

        ArrayList<AbstractCard> ATTACKB = new ArrayList<>();
        ATTACKB.add(new Dredge());
        machClaw = new MachClaw();
        machClaw.calculateCardDamage(m);
        ATTACKB.add(machClaw);
        addToBot(new ChooseOneAction(ATTACKB));
     }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Excadrill();
    }
}

