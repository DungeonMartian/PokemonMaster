package pokemonmaster.cards.Metal;

import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.ExhaustiveField;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PlatedArmorPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Skarmory extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Skarmory",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);



    public Skarmory() {
        super(cardInfo);	
        setExhaust(true);
        tags.add(CustomTags.METAL);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillMetal.png","pokemonmaster/character/cardback/bg_skillMetal_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        int count = AbstractDungeon.player.hand.size();
        {
            addToTop(new DiscardAction(AbstractDungeon.player, AbstractDungeon.player, count, true));
            for (int i = 1; i <= count-1; i++) {
                addToBot(new ApplyPowerAction(p, p, new PlatedArmorPower(p, 1)));
            }
        }
    }



    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            ExhaustiveField.ExhaustiveFields.baseExhaustive.set(this, 2);
            ExhaustiveField.ExhaustiveFields.exhaustive.set(this, 2);
            exhaust = false;
            this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
            initializeDescription();
        }
    }




    @Override
    public AbstractCard makeCopy() { //Optional
        return new Skarmory();
    }
}

