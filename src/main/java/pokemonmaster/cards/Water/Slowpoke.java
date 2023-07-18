package pokemonmaster.cards.Water;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Burned;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Slowpoke extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Slowpoke",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 4;
    private static final int UPG_DAMAGE = 2;

    private static final int MAGIC = 5;
    private static final int UPG_MAGIC = 2;

    public Slowpoke() {
        super(cardInfo,new Slowbro(),new Slowbro(),CustomTags.WATER);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(MAGIC,UPG_MAGIC);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackWater.png","pokemonmaster/character/cardback/bg_attackWater_p.png");
    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        addToBot(new ApplyPowerAction(m, p, new Burned(m, 2)));

    }

    @Override
    public void triggerOnManualDiscard() {
        super.onMoveToDiscard();
        addToBot(new HealAction(AbstractDungeon.player, AbstractDungeon.player, this.magicNumber));
        addToBot(new ExhaustSpecificCardAction(this, AbstractDungeon.player.discardPile));

    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new Slowpoke();
    }
}

