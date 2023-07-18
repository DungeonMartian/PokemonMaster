package pokemonmaster.cards.Base;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import pokemonmaster.CustomTags;
import pokemonmaster.cards.BasicPokemonCard;
import pokemonmaster.jar.PokemonMaster;
import pokemonmaster.util.CardInfo;

import static pokemonmaster.PokemonMasterMod.makeID;

public class Pikachu2 extends BasicPokemonCard {
    private final static CardInfo cardInfo = new CardInfo(
            "Pikachu2",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.BASIC,
            PokemonMaster.Enums.CARD_COLOR);



    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 6;
    private static final int UPG_DAMAGE = 3;



    public Pikachu2() {
        super(cardInfo, new Raichu(), new Raichu(), CustomTags.LIGHTNING);
        setBackgroundTexture("E:/PokeSpire/BasicMod/src/main/resources/pokemonmaster/cards/attack/Pikachu2.png", "E:/PokeSpire/BasicMod/src/main/resources/pokemonmaster/cards/attack/Pikachu2.png");
        setDamage(DAMAGE, UPG_DAMAGE);
        tags.add(CustomTags.POKEMON);
        tags.add(CardTags.STARTER_STRIKE);
        tags.add(CardTags.STRIKE);

    }


    @Override
    public void onUse(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        //addToBot(new MakeTempCardInDiscardAction(new Raichu(), 1));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Pikachu2();
    }
}

