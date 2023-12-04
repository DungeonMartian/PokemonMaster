package pokemonmaster.cards.Metal;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PlatedArmorPower;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BaseCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.powers.FuryCutterPower;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Scizor extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Scizor",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 2;

    private static final int FURY = 2;
    private static final int FURYUP = 2;


    public Scizor() {
        super(cardInfo);
        setDamage(DAMAGE);
        setMagic(FURY,FURYUP);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.METAL);
        tags.add(CustomTags.UNEVOLVED);
        this.returnToHand=true;
        tags.add(CardTags.STRIKE);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackMetal.png","pokemonmaster/character/cardback/bg_attackMetal_p.png");

    }
   
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        addToTop(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new PlatedArmorPower(AbstractDungeon.player, 1), 1));
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        addToBot(new ApplyPowerAction(p, p, new FuryCutterPower(p, magicNumber)));
        this.costForTurn=1;
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Scizor();
    }
}

