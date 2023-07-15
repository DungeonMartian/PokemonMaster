package pokemonmaster.cards.Psychic;

import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class MirageGate extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "MirageGate",
            0,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int ENERGY = 2;
    private static final int UPG_ENERGY = 1;



    public MirageGate() {
        super(cardInfo);
        setMagic(ENERGY,UPG_ENERGY);
        tags.add(CustomTags.PSYCHIC);
        this.exhaust=true;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillPsychic.png","pokemonmaster/character/cardback/bg_skillPsychic_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        int EXHAUST = p.exhaustPile.size();
        if (EXHAUST >= 7) {
            addToBot(new GainEnergyAction(magicNumber));
        }
    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new MirageGate();
    }
}

