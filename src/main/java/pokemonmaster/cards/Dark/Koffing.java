package pokemonmaster.cards.Dark;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.unique.BouncingFlaskAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Koffing extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Koffing",
            1,
            CardType.SKILL,
            CardTarget.SELF,
            CardRarity.UNCOMMON,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 4;
    private static final int UPG_DAMAGE= 2;
    private static final int POISON = 3;
    private static final int UPG_POISON= 2;


    public Koffing() {
        super(cardInfo,new Wheezing(),new Wheezing(),CustomTags.DARK);
        setDamage(DAMAGE,UPG_DAMAGE);
        setMagic(POISON,UPG_POISON);

        tags.add(CustomTags.POKEMON);
        tags.add(CustomTags.UNEVOLVED);


        this.setBackgroundTexture("pokemonmaster/character/cardback/bg_skillDark.png","pokemonmaster/character/cardback/bg_skillDark_p.png");
        this.damageTypeForTurn= DamageInfo.DamageType.THORNS;
        this.damageType= DamageInfo.DamageType.THORNS;
    }



    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        AbstractMonster randomMonster = AbstractDungeon.getMonsters().getRandomMonster(null, true, AbstractDungeon.cardRandomRng);
        addToBot( new BouncingFlaskAction( randomMonster, magicNumber, 1));

    }

    @Override
    public void triggerOnManualDiscard() {
        super.onMoveToDiscard();

        AbstractMonster randomMonster = AbstractDungeon.getMonsters().getRandomMonster(null, true, AbstractDungeon.cardRandomRng);
        if (randomMonster != null){
            addToBot(new DamageAction(randomMonster, new DamageInfo(AbstractDungeon.player, damage, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.POISON));
            addToBot( new BouncingFlaskAction( randomMonster, magicNumber, 1));
        }

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Koffing();
    }
}

