package pokemonmaster.cards.Normal;

import com.megacrit.cardcrawl.actions.unique.FeedAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Taillow extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Taillow",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 6;
    private static final int UPG_DAMAGE = 3;
    private static final int MAGIC = 2;



    public Taillow() {
        super(cardInfo, new Swellow(), new Swellow(), CustomTags.NORMAL);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(MAGIC);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackNormal.png","pokemonmaster/character/cardback/bg_attackNormal_p.png");
        tags.add(CardTags.STRIKE);
        tags.add(CardTags.HEALING);
    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        if (m != null) {
            addToBot(new FeedAction(m, new DamageInfo( p, this.damage, this.damageTypeForTurn), this.magicNumber));
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Taillow();
    }
}

