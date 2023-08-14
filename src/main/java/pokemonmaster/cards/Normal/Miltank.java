package pokemonmaster.cards.Normal;

import com.megacrit.cardcrawl.actions.watcher.ChooseOneAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.Base.BasePokemonCard;
import pokemonmaster.cards.ChoiceCards.DefenseCurl;
import pokemonmaster.cards.ChoiceCards.Rollout;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import java.util.ArrayList;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Miltank extends BasePokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Miltank",
            1,
            CardType.ATTACK,
            CardTarget.ALL_ENEMY,
            CardRarity.COMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 2;
    private static final int UPG_DAMAGE = 1;
    private static final int MAGIC = 2;
    private static final int UPG_MAGIC = 1;


    public Miltank() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(MAGIC,UPG_MAGIC);
        tags.add(CustomTags.NORMAL);
        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);
        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_attackNormal.png","pokemonmaster/character/cardback/bg_attackNormal_p.png");

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        ArrayList<AbstractCard> ATTACK = new ArrayList<>();
        ATTACK.add(new DefenseCurl());
        DefenseCurl defenseCurl = new DefenseCurl();
        defenseCurl.magicNumber = this.magicNumber;
        defenseCurl.applyPowers();
        Rollout rollout = new Rollout();
        rollout.baseDamage = this.baseDamage;
        rollout.calculateCardDamage(m);
        ATTACK.add(rollout);
        addToBot(new ChooseOneAction(ATTACK));
        this.baseDamage += this.baseDamage;


        //addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Miltank();
    }
}

