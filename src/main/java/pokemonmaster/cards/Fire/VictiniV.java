package pokemonmaster.cards.Fire;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Prized;
import pokemonmaster.powers.Spark;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class VictiniV extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "VictiniV",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.RARE,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);






    public VictiniV() {
        super(cardInfo);
        this.exhaust=true;
        setCostUpgrade(0);
        tags.add(CustomTags.FIRE);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillFire.png","pokemonmaster/character/cardback/bg_skillFire_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if (!p.discardPile.isEmpty()) {
            if (!AbstractDungeon.player.discardPile.isEmpty()) {
                if (AbstractDungeon.player.discardPile.size() <= 2) {
                    for (int i = 1; i <= AbstractDungeon.player.discardPile.size(); ) {
                        AbstractCard card = AbstractDungeon.player.discardPile.getRandomCard(true);
                        AbstractDungeon.player.discardPile.moveToExhaustPile(card);
                        addToBot(new ApplyPowerAction(p, p, new Spark(p, 1)));
                    }
                }
                if (AbstractDungeon.player.discardPile.size() >= 3) {
                    for (int i = 1;  i <= 3; i++) {
                        AbstractCard card = AbstractDungeon.player.discardPile.getRandomCard(true);
                        AbstractDungeon.player.discardPile.moveToExhaustPile(card);
                        addToBot(new ApplyPowerAction(p, p, new Spark(p, 1)));
                    }
                }
            }
        }
        addToBot(new ApplyPowerAction(p, p, new Prized(p,1)));

    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new VictiniV();
    }
}

