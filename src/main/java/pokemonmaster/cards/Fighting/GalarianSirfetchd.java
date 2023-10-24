package pokemonmaster.cards.Fighting;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.AttackDamageRandomEnemyAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.EntanglePower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.FinalEvolutionCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.SirFetchSnooze;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class GalarianSirfetchd extends FinalEvolutionCard {
    private final static CardInfo cardInfo = new CardInfo(
            "GalarianSirfetch'd",
            3,
            CardType.ATTACK,
            CardTarget.ALL_ENEMY,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 18;
    private static final int UPG_DAMAGE = 5;



    public GalarianSirfetchd() {
        super(cardInfo,CustomTags.FIGHTING);
        setDamage(DAMAGE, UPG_DAMAGE);


        this.exhaust=true;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackFighting.png","pokemonmaster/character/cardback/bg_attackFighting_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new AttackDamageRandomEnemyAction(this, AbstractGameAction.AttackEffect.SLASH_VERTICAL));
        addToBot(new AttackDamageRandomEnemyAction(this, AbstractGameAction.AttackEffect.SLASH_VERTICAL));
        addToBot(new AttackDamageRandomEnemyAction(this, AbstractGameAction.AttackEffect.SLASH_VERTICAL));
        addToBot(new ApplyPowerAction(p, p, new EntanglePower(p)));
        addToBot(new ApplyPowerAction(p, p, new SirFetchSnooze(p,1)));
        AbstractCard s = (new GalarianFarfetchd()).makeCopy();
        if (this.upgraded) {
            s.upgrade();
        }
        AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDiscardAction(s,1));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new GalarianSirfetchd();
    }
}

