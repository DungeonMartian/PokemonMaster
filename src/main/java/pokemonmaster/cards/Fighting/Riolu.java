package pokemonmaster.cards.Fighting;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.actions.unique.SetupAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Riolu extends BaseCard {
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
        super(cardInfo);
        setMagic(RIOENERGY,RIOENERGYUP);
        tags.add(CustomTags.FIGHTING);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.EVOLVED);
        purgeOnUse = true;
        this.cardsToPreview = new Lucario();
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillFighting.png","pokemonmaster/character/cardback/bg_skillFighting_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new SetupAction());
        if (this.upgraded) {
            addToBot(new SetupAction());
        }
        AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDiscardAction(new Lucario(), 1));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Riolu();
    }
}

