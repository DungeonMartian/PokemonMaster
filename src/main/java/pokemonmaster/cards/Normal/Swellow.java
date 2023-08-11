package pokemonmaster.cards.Normal;

import com.megacrit.cardcrawl.actions.unique.FeedAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Swellow extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Swellow",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 12;
    private static final int UPG_DAMAGE = 6;

    private static final int MAGIC = 3;
    private static final int UPG_MAGIC = 2;

    public Swellow() {
        super(cardInfo,CustomTags.NORMAL);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(MAGIC, UPG_MAGIC);
        tags.add(CardTags.STRIKE);
        this.exhaust = true;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackNormal.png","pokemonmaster/character/cardback/bg_attackNormal_p.png");

    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        if (m != null) {
            addToBot(new FeedAction(m, new DamageInfo( p, this.damage, this.damageTypeForTurn), this.magicNumber));
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Swellow();
    }
}

