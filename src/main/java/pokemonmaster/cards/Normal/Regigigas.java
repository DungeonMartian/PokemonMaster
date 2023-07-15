package pokemonmaster.cards.Normal;

import com.evacipated.cardcrawl.mod.stslib.cards.interfaces.StartupCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.cards.Dragon.Regidrago;
import pokemonmaster.cards.Fighting.Regirock;
import pokemonmaster.cards.Lightning.Regieleki;
import pokemonmaster.cards.Metal.Registeel;
import pokemonmaster.cards.Water.Regice;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.SlowStart;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Regigigas extends BasePokemonCard implements StartupCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Regigigas",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 100;
    private static final int UPG_DAMAGE= 50;



    public Regigigas() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        tags.add(CustomTags.NORMAL);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        tags.add(CustomTags.REGIGIGAS);
        tags.add(CardTags.HEALING);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackNormal.png","pokemonmaster/character/cardback/bg_attackNormal_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_HEAVY));



    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Regigigas();
    }

    @Override
    public boolean atBattleStartPreDraw() {
        AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDrawPileAction(new Registeel(), 1, true, false));
        AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDrawPileAction(new Regirock(), 1, true, false));
        AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDrawPileAction(new Regieleki(), 1, true, false));
        AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDrawPileAction(new Regice(), 1, true, false));
        AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDrawPileAction(new Regidrago(), 1, true, false));
        addToBot(new ExhaustSpecificCardAction(this, AbstractDungeon.player.drawPile));
        addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new SlowStart(AbstractDungeon.player,magicNumber)));
        return true;
    }
}

