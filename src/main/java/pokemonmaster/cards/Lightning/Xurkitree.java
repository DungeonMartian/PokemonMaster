package pokemonmaster.cards.Lightning;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Xurkitree extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Xurkitree",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 18;
    private static final int UPG_DAMAGE = 6;



    public Xurkitree() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        tags.add(CustomTags.LIGHTNING);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.returnToHand=true;
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackLightning.png","pokemonmaster/character/cardback/bg_attackLightning_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        if (!AbstractDungeon.player.drawPile.isEmpty()) {
            if (AbstractDungeon.player.drawPile.size() <=2) {
                for (int i = 1; i <= AbstractDungeon.player.drawPile.size();) {
                    AbstractCard card = AbstractDungeon.player.drawPile.getTopCard();
                    AbstractDungeon.player.drawPile.moveToExhaustPile(card);
                }
            }
            if (AbstractDungeon.player.drawPile.size() >=3) {
                for (int i = 1;  i <= 3; i++) {
                    AbstractCard card = AbstractDungeon.player.drawPile.getTopCard();
                    AbstractDungeon.player.drawPile.moveToExhaustPile(card);
                }
            }

        }
        this.costForTurn=1;

    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new Xurkitree();
    }
}

