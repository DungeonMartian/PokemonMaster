package pokemonmaster.cards.Dark;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Prized;
import pokemonmaster.powers.Spark;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class GalarianMoltresGX extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "GalarianMoltresGX",
            2,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 15;
    private static final int UPG_DAMAGE = 10;
    private static final int MAGIC = 2;


    public GalarianMoltresGX() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(MAGIC);
        tags.add(CustomTags.DARK);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackDark.png","pokemonmaster/character/cardback/bg_attackDark_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        if (!p.discardPile.isEmpty()) {
            if (!AbstractDungeon.player.discardPile.isEmpty()) {
                if (AbstractDungeon.player.discardPile.size() < 2) {
                    for (int i = 1; i <= AbstractDungeon.player.discardPile.size(); ) {
                        AbstractCard card = AbstractDungeon.player.discardPile.getRandomCard(true);
                        AbstractDungeon.player.discardPile.moveToExhaustPile(card);
                    }
                }
                if (AbstractDungeon.player.discardPile.size() >= 2) {
                    for (int i = 0; i <= AbstractDungeon.player.discardPile.size() && i <= 2; i++) {
                        AbstractCard card = AbstractDungeon.player.discardPile.getRandomCard(true);
                        AbstractDungeon.player.discardPile.moveToExhaustPile(card);
                    }
                }
            }
        }
        addToBot(new ApplyPowerAction(p, p, new Spark(p, 1)));
        addToBot(new ApplyPowerAction(p, p, new Prized(p,1)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new GalarianMoltresGX();
    }
}

