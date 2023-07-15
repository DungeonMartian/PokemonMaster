package pokemonmaster.cards.Dark;

import com.evacipated.cardcrawl.mod.stslib.actions.common.SelectCardsInHandAction;
import com.megacrit.cardcrawl.actions.common.DiscardSpecificCardAction;
import com.megacrit.cardcrawl.actions.unique.BouncingFlaskAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import java.util.function.Predicate;

import static pokemonmaster.CustomTags.POKEMON;
import static pokemonmaster.PokemonMasterMod.makeID;

public class Muk extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Muk",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.SPECIAL,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGIC = 6;
    private static final int UPG_MAGIC = 2;


    public Muk() {
        super(cardInfo);
        setMagic(MAGIC,UPG_MAGIC);
        tags.add(CustomTags.DARK);
        tags.add(POKEMON);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillDark.png","pokemonmaster/character/cardback/bg_skillDark_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new SelectCardsInHandAction(p.hand.size(), "discard", true, true, (Predicate<AbstractCard>) card -> true, abstractCards -> {
            for (AbstractCard i : abstractCards) {
                addToBot(new DiscardSpecificCardAction(i));
                AbstractMonster randomMonster = AbstractDungeon.getMonsters().getRandomMonster(null, true, AbstractDungeon.cardRandomRng);
                if (randomMonster != null){
                //    addToBot(new VFXAction(new PotionBounceEffect(p.hb.cX, p.hb.cY, randomMonster.hb.cX, this.hb.cY), 0.4F));
                    addToBot( new BouncingFlaskAction( randomMonster, magicNumber, 1));
                }
            }
        }));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Muk();
    }
}

