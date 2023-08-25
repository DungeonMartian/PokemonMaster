package pokemonmaster.cards.Dragon;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.status.VoidCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Prized;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class GiratinaGX extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "GiratinaGX",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 15;
    private static final int UPG_DAMAGE = 6;




    public GiratinaGX() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        tags.add(CustomTags.DRAGON);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackDragon.png","pokemonmaster/character/cardback/bg_attackDragon_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        addToBot(new ApplyPowerAction(p, p, new Prized(p,1)));
    }
    @Override
    public void triggerOnManualDiscard() {
        super.onMoveToDiscard();
        addToBot(new AttackDamageRandomEnemyAction(this, AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
    }

    @Override
    public void atTurnStart() {
        if (AbstractDungeon.player.discardPile.contains(this)) {
            addToBot(new AbstractGameAction() {
                @Override
                public void update() {
                    isDone = true;
                    AbstractDungeon.player.discardPile.moveToHand(GiratinaGX.this);
                    AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDiscardAction(new VoidCard(), 1));

                }
            });
        }
    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new GiratinaGX();
    }
}

