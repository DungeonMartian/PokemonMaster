package pokemonmaster.cards.Water;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ThornsPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.Prized;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class SharpedoEX extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "SharpedoEX",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGIC = 2;
    private static final int UPG_MAGIC = 1;



    public SharpedoEX() {
        super(cardInfo);
        setMagic(MAGIC,UPG_MAGIC);
        tags.add(CustomTags.WATER);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);

        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillWater.png","pokemonmaster/character/cardback/bg_skillWater_p.png");
        this.exhaust=true;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        int count = AbstractDungeon.player.hand.size();
        {
            addToTop(new DiscardAction(AbstractDungeon.player, AbstractDungeon.player, count, true));
            for (int i = 1; i <= count-1; i++) {
                addToBot(new ApplyPowerAction(p, p, new ThornsPower(p, magicNumber)));
            }
        }
        addToBot(new ApplyPowerAction(p, p, new Prized(p, 1)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new SharpedoEX();
    }
}

