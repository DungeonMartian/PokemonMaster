package pokemonmaster.cards.Dragon;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Gible extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Gible",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int BLOCK = 3;




    public Gible() {
        super(cardInfo);
        tags.add(CustomTags.DRAGON);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillDragon.png","pokemonmaster/character/cardback/bg_skillDragon_p.png");
        this.evolve=new Garchomp();
        this.purgeOnUse = this.evolve !=null;
        setBlock(BLOCK);

        this.cardsToPreview=this.evolve;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractCard s = new Gabite();
        if (this.upgraded) {
            addToBot(new GainBlockAction(p, p, block));

            s.upgrade();
        }
        addToBot(new MakeTempCardInHandAction(s, 1));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Gible();
    }
}

