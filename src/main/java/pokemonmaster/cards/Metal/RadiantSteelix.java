package pokemonmaster.cards.Metal;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.AttackDamageRandomEnemyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static com.megacrit.cardcrawl.cards.AbstractCard.CardType.ATTACK;
import static pokemonmaster.PokemonMasterMod.makeID;

public class RadiantSteelix extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "RadiantSteelix",
            3,
            ATTACK,
            CardTarget.ALL_ENEMY,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 15;
    private static final int UPG_DAMAGE = 3;

    public RadiantSteelix() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        tags.add(CustomTags.METAL);
        tags.add(CustomTags.POKEMON);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackMetal.png","pokemonmaster/character/cardback/bg_attackMetal_p.png");

    }

    @Override
  public void use(AbstractPlayer p, AbstractMonster m) {
        if (!AbstractDungeon.player.drawPile.isEmpty()) {
            for (int i = 1; i <= AbstractDungeon.player.drawPile.size();) {
                AbstractCard card = AbstractDungeon.player.drawPile.getTopCard();
                AbstractDungeon.player.drawPile.moveToExhaustPile(card);
                if (card.type == AbstractCard.CardType.STATUS) {
                    addToBot(new AttackDamageRandomEnemyAction(this, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
                }

            }
        }
    }
    @Override
    public AbstractCard makeCopy() {
        return new RadiantSteelix();
    }
}

