package pokemonmaster.cards.Normal;

import com.evacipated.cardcrawl.mod.stslib.actions.common.FetchAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.SupporterPlayed;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.CustomTags.NORMAL;
import static pokemonmaster.CustomTags.POKEMON;
import static pokemonmaster.PokemonMasterMod.makeID;

public class Winona extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Winona",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);


    public Winona() {
        super(cardInfo);

        tags.add(CustomTags.NORMAL);
        tags.add(CustomTags.SUPPORTER);
        setExhaust(true,false);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillNormal.png","pokemonmaster/character/cardback/bg_skillNormal_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractPower pow = AbstractDungeon.player.getPower(SupporterPlayed.POWER_ID);
        if (pow == null) {
            addToBot(new FetchAction(p.drawPile, card -> card.hasTag(POKEMON) &&card.hasTag(NORMAL),3, abstractCards -> {
                addToBot(new ApplyPowerAction(p, p, new SupporterPlayed(p, 1)));

            }));
        }

    }

    public void triggerOnGlowCheck() {
        this.glowColor = AbstractCard.BLUE_BORDER_GLOW_COLOR.cpy();
        AbstractPower pow = AbstractDungeon.player.getPower(SupporterPlayed.POWER_ID);
        if (pow == null) {
            this.glowColor = AbstractCard.GOLD_BORDER_GLOW_COLOR.cpy();
        }
    }

        @Override
    public AbstractCard makeCopy() { //Optional
        return new Winona();
    }
}

