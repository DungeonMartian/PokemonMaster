package pokemonmaster.cards.ChoiceCards;

import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.unique.BouncingFlaskAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.combat.PotionBounceEffect;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class BitterBerry extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "BitterBerry",
            -2,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int POISON = 8;//if you change these remember to change the parent
    private static final int UPG_POISON = 2;




    public BitterBerry() {
        super(cardInfo);
        setMagic(POISON,UPG_POISON);

    }

    @Override


    public void use(AbstractPlayer p, AbstractMonster m) {

        onChoseThisOption();
    }

    public void onChoseThisOption() {
        AbstractPlayer p = AbstractDungeon.player;
        AbstractMonster randomMonster = AbstractDungeon.getMonsters().getRandomMonster(null, true, AbstractDungeon.cardRandomRng);
        if (randomMonster != null){
            addToBot(new VFXAction(new PotionBounceEffect(p.hb.cX, p.hb.cY, randomMonster.hb.cX, this.hb.cY), 0.4F));
            addToBot( new BouncingFlaskAction( randomMonster, magicNumber, 1));
    }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new BitterBerry();
    }
}

