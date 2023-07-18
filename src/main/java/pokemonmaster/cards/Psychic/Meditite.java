package pokemonmaster.cards.Psychic;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.status.Dazed;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.IntangiblePlayerPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Meditite extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Meditite",
            3,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);

    public static final String ID = makeID(cardInfo.baseId);

    public Meditite() {
        super(cardInfo,new Medicham(),new Medicham(),CustomTags.PSYCHIC);

        setCostUpgrade(2);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillPsychic.png","pokemonmaster/character/cardback/bg_skillPsychic_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDrawPileAction(new Dazed(), 2, false, true));
        addToBot(new ApplyPowerAction(p, p, new IntangiblePlayerPower(p, 1), 1));


    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Meditite();
    }
}

