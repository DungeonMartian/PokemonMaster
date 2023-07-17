package pokemonmaster.cards.Fire;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Prized;
import pokemonmaster.util.Actions.DelphoxVAction;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class DelphoxV extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "DelphoxV",
            1,
            CardType.SKILL,
            CardTarget.ALL_ENEMY,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);





    public DelphoxV() {
        super(cardInfo);
        tags.add(CustomTags.FIRE);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillFire.png","pokemonmaster/character/cardback/bg_skillFire_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DelphoxVAction());
        addToBot(new ApplyPowerAction(p, p, new Prized(p,1)));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new DelphoxV();
    }
}

