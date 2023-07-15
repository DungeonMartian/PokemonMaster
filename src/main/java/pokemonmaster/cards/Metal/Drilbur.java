package pokemonmaster.cards.Metal;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Drilbur extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Drilbur",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);


    private static final int DAMAGE = 4;
    private static final int UPG_DAMAGE= 2;
    private static final int BLOCK = 4;
    private static final int UPG_BLOCK= 2;
    public Drilbur() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        setBlock(BLOCK, UPG_BLOCK);
        purgeOnUse = true;
        tags.add(CustomTags.METAL);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.EVOLVED);
        this.cardsToPreview = new Excadrill();
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackMetal.png","pokemonmaster/character/cardback/bg_attackMetal_p.png");

    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        addToBot(new GainBlockAction(p, p, block));
        addToBot(new MakeTempCardInDiscardAction(new Excadrill(), 1));

    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new Drilbur();
    }
}

