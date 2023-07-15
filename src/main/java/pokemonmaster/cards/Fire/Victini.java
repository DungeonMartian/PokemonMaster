package pokemonmaster.cards.Fire;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Spark;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Victini extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Victini",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 5;




    public Victini() {
        super(cardInfo);
        setCostUpgrade(0);
        setDamage(DAMAGE);
        tags.add(CustomTags.FIRE);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackFire.png","pokemonmaster/character/cardback/bg_attackFire_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if (!p.discardPile.isEmpty()) {
            if (!AbstractDungeon.player.discardPile.isEmpty()) {
                if (AbstractDungeon.player.discardPile.size() <= 2) {
                    for (int i = 1; i <= AbstractDungeon.player.discardPile.size(); ) {
                        AbstractCard card = AbstractDungeon.player.discardPile.getRandomCard(true);
                        AbstractDungeon.player.discardPile.moveToExhaustPile(card);
                    }
                }
                if (AbstractDungeon.player.discardPile.size() >= 3) {
                    if (AbstractDungeon.player.discardPile.size() >= 3) {
                        for (int i = 1;  i <= 3; i++) {
                            AbstractCard card = AbstractDungeon.player.discardPile.getRandomCard(true);
                            AbstractDungeon.player.discardPile.moveToExhaustPile(card);

                        }
                    }
                }
            }
        }
        addToBot(new ApplyPowerAction(p, p, new Spark(p, 1)));
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));

    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new Victini();
    }
}

