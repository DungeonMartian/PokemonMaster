package pokemonmaster.cards.Fighting;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.actions.unique.SetupAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ArtifactPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Riolu extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Riolu",
            0,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int RIOENERGY = 1;
    private static final int RIOENERGYUP = 1;




    public Riolu() {
        super(cardInfo,new Lucario(),new Lucario(),CustomTags.FIGHTING);
        setMagic(RIOENERGY,RIOENERGYUP);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillFighting.png","pokemonmaster/character/cardback/bg_skillFighting_p.png");

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new SetupAction());
        if (this.upgraded) {
            addToBot(new SetupAction());
        }
        addToBot(new ApplyPowerAction(p, p, new ArtifactPower(p,magicNumber)));

        AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDiscardAction(new Lucario(), 1));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Riolu();
    }
}

