package pokemonmaster.cards.Dragon;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.Actions.EvolveActionCombat;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Axew extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Axew",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);




    public Axew() {
        super(cardInfo);
        tags.add(CustomTags.DRAGON);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        setCostUpgrade(0);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillDragon.png","pokemonmaster/character/cardback/bg_skillDragon_p.png");
        this.evolve=new Haxorus();
        this.purgeOnUse = this.evolve !=null;

        this.cardsToPreview=this.evolve;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        for (AbstractMonster j : (AbstractDungeon.getCurrRoom()).monsters.monsters) {
            if (j.type == AbstractMonster.EnemyType.BOSS || j.type == AbstractMonster.EnemyType.ELITE) {
                addToBot(new EvolveActionCombat(this,"hand"));
            }
            }

        addToBot(new MakeTempCardInDiscardAction(new Fraxure(), 1));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Axew();
    }
}

