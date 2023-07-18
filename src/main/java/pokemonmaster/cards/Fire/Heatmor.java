package pokemonmaster.cards.Fire;

import com.evacipated.cardcrawl.mod.stslib.actions.common.SelectCardsAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Spark;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Heatmor extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Heatmor",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 4;




    public Heatmor() {
        super(cardInfo);
        setBlock(BLOCK);
        setInnate(false,true);
        tags.add(CustomTags.FIRE);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillFire.png","pokemonmaster/character/cardback/bg_skillFire_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if (!AbstractDungeon.player.drawPile.isEmpty()) {
            addToTop(new SelectCardsAction(AbstractDungeon.player.drawPile.group, 1, "Choose a card to exhaust", (cards) -> {
                for (AbstractCard c : cards) {
                    for (int i =0; i < c.cost; i++) {
                        addToBot(new GainBlockAction(p, p, block));
                        addToBot(new ApplyPowerAction(p, AbstractDungeon.player, new Spark(p, 1)));
                    }
                }
            }));

        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Heatmor();
    }
}

