package controllers;

import models.*;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import javax.inject.Inject;
import java.util.List;

public class CharacterController extends Controller
{
    private FormFactory formFactory;
    private JPAApi jpaApi;

    @Inject
    public CharacterController (FormFactory formFactory, JPAApi jpaApi)
    {
        this.formFactory = formFactory;
        this.jpaApi = jpaApi;
    }

    @Transactional
    public Result getNewCharacter()
    {
        String raceSQL = "SELECT r FROM Race r";
        List<Race> races = jpaApi.em().createQuery(raceSQL, Race.class).getResultList();

        String classTypeSQL = "SELECT ct FROM ClassType ct";
        List<ClassType> classTypes = jpaApi.em().createQuery(classTypeSQL, ClassType.class).getResultList();

        String backgroundSQL = "SELECT b FROM Background b";
        List<Background> backgrounds = jpaApi.em().createQuery(backgroundSQL, Background.class).getResultList();

        return ok(views.html.newcharacter.render(races, classTypes, backgrounds));
    }

    @Transactional
    public Result postNewCharacter()
    {
        DynamicForm form = formFactory.form().bindFromRequest();

        String characterName = form.get("characterName");
        String result;

        Background background;
        ClassType classType;
        Race race;

        GameCharacter gameCharacter = new GameCharacter();

        int raceId = Integer.parseInt(form.get("raceId"));
        String raceSQL = "SELECT r FROM Race r WHERE RaceId = :raceId";
        race = jpaApi.em().createQuery(raceSQL, Race.class).setParameter("raceId", raceId).getSingleResult();

        int classTypeId = Integer.parseInt(form.get("classTypeId"));
        String classTypeSQL = "SELECT ct FROM ClassType ct WHERE ClassTypeId = :classId";
        classType = jpaApi.em().createQuery(classTypeSQL, ClassType.class).setParameter("classId", classTypeId).getSingleResult();

        //classType = classTypes.get(0);
        int hitDice = classType.getHitDice();
        int backgroundId = Integer.parseInt(form.get("backgroundId"));
        String backgroundSQL = "SELECT b FROM Background b WHERE BackgroundId = :backgroundId";
        background = jpaApi.em().createQuery(backgroundSQL, Background.class).setParameter("backgroundId", backgroundId).getSingleResult();

        int level = Integer.parseInt(form.get("level"));
        int strength = gameCharacter.getNewStrength();
        int dexterity = gameCharacter.getNewDexterity();
        int constitution = gameCharacter.getNewConstitution();
        int intelligence = gameCharacter.getNewIntelligence();
        int wisdom = gameCharacter.getNewWisdom();
        int charisma = gameCharacter.getNewCharisma();
        int acrobatics;
        if (race.getAcrobatics() == 1 || classType.getAcrobatics() == 1 || background.getAcrobatics() == 1)
        {
            acrobatics = 1;
        }
        else
        {
            acrobatics = 0;
        }
        int animalHandling;
        if (race.getAnimalHandling() == 1 || classType.getAnimalHandling() == 1 || background.getAnimalHandling() == 1)
        {
            animalHandling = 1;
        }
        else
        {
            animalHandling = 0;
        }
        int arcana;
        if (race.getArcana() == 1 || classType.getArcana() == 1 || background.getArcana() == 1)
        {
            arcana = 1;
        }
        else
        {
            arcana = 0;
        }
        int athletics;
        if (race.getAthletics() == 1 || classType.getAthletics() == 1 || background.getAthletics() == 1)
        {
            athletics = 1;
        }
        else
        {
            athletics = 0;
        }
        int deception;
        if (race.getDeception() == 1 || classType.getDeception() == 1 || background.getDeception() == 1)
        {
            deception = 1;
        }
        else
        {
            deception = 0;
        }
        int history;
        if (race.getHistory() == 1 || classType.getHistory() == 1 || background.getHistory() == 1)
        {
            history = 1;
        }
        else
        {
            history = 0;
        }
        int insight;
        if (race.getInsight() == 1 || classType.getInsight() == 1 || background.getInsight() == 1)
        {
            insight = 1;
        }
        else
        {
            insight = 0;
        }
        int intimidation;
        if (race.getIntimidation() == 1 || classType.getIntimidation() == 1 || background.getIntimidation() == 1)
        {
            intimidation = 1;
        }
        else
        {
            intimidation = 0;
        }
        int investigation;
        if (race.getInvestigation() == 1 || classType.getInvestigation() == 1 || background.getInvestigation() == 1)
        {
            investigation = 1;
        }
        else
        {
            investigation = 0;
        }
        int medicine;
        if (race.getMedicine() == 1 || classType.getMedicine() == 1 || background.getMedicine() == 1)
        {
            medicine = 1;
        }
        else
        {
            medicine = 0;
        }
        int nature;
        if (race.getNature() == 1 || classType.getNature() == 1 || background.getNature() == 1)
        {
            nature = 1;
        }
        else
        {
            nature = 0;
        }
        int perception;
        if (race.getPerception() == 1 || classType.getPerception() == 1 || background.getPerception() == 1)
        {
            perception = 1;
        }
        else
        {
            perception = 0;
        }
        int performance;
        if (race.getPerformance() == 1 || classType.getPerformance() == 1 || background.getPerformance() == 1)
        {
            performance = 1;
        }
        else
        {
            performance = 0;
        }
        int persuasion;
        if (race.getPersuasion() == 1 || classType.getPersuasion() == 1 || background.getPersuasion() == 1)
        {
            persuasion = 1;
        }
        else
        {
            persuasion = 0;
        }
        int religion;
        if (race.getReligion() == 1 || classType.getReligion() == 1 || background.getReligion() == 1)
        {
            religion = 1;
        }
        else
        {
            religion = 0;
        }
        int sleightOfHand;
        if (race.getSleightOfHand() == 1 || classType.getSleightOfHand() == 1 || background.getSleightOfHand() == 1)
        {
            sleightOfHand = 1;
        }
        else
        {
            sleightOfHand = 0;
        }
        int stealth;
        if (race.getStealth() == 1 || classType.getStealth() == 1 || background.getStealth() == 1)
        {
            stealth = 1;
        }
        else
        {
            stealth = 0;
        }
        int survival;
        if (race.getSurvival() == 1 || classType.getSurvival() == 1 || background.getSurvival() == 1)
        {
            survival = 1;
        }
        else
        {
            survival = 0;
        }

        gameCharacter.setCharacterName(characterName);
        gameCharacter.setLevel(level);
        gameCharacter.setStrength(strength);
        gameCharacter.setDexterity(dexterity);
        gameCharacter.setConstitution(constitution);
        gameCharacter.setIntelligence(intelligence);
        gameCharacter.setWisdom(wisdom);
        gameCharacter.setCharisma(charisma);
        gameCharacter.setRaceId(raceId);
        gameCharacter.setClassTypeId(classTypeId);
        gameCharacter.setHitDice(hitDice);
        gameCharacter.setBackgroundId(backgroundId);
        gameCharacter.setAcrobatics(acrobatics);
        gameCharacter.setAnimalHandling(animalHandling);
        gameCharacter.setArcana(arcana);
        gameCharacter.setAthletics(athletics);
        gameCharacter.setDeception(deception);
        gameCharacter.setHistory(history);
        gameCharacter.setInsight(insight);
        gameCharacter.setIntimidation(intimidation);
        gameCharacter.setInvestigation(investigation);
        gameCharacter.setMedicine(medicine);
        gameCharacter.setNature(nature);
        gameCharacter.setPerception(perception);
        gameCharacter.setPerformance(performance);
        gameCharacter.setPersuasion(persuasion);
        gameCharacter.setReligion(religion);
        gameCharacter.setSleightOfHand(sleightOfHand);
        gameCharacter.setStealth(stealth);
        gameCharacter.setSurvival(survival);

        jpaApi.em().persist(gameCharacter);

        result = "Saved";

        return ok(result);
    }

    @Transactional
    public Result getCharacter(int characterId)
    {
        String sql = "SELECT c FROM GameCharacter c WHERE characterId = :characterId";

        GameCharacter gameCharacter = jpaApi.em().createQuery(sql, GameCharacter.class).setParameter("characterId", characterId).getSingleResult();

        return ok(views.html.character.render(gameCharacter));
    }

    @Transactional (readOnly = true)
    public Result getCharacterDetails()
    {
        String sql = "SELECT NEW models.CharacterDetails(c.characterId, c.characterName, c.level, r.raceName, ct.classTypeName, b.backgroundName) " +
                     "FROM GameCharacter c JOIN Race r ON c.raceId = r.raceId " +
                     "LEFT OUTER JOIN ClassType ct ON c.classTypeId = ct.classTypeId " +
                     "LEFT OUTER JOIN Background b ON c.backgroundId = b.backgroundId";

        List<CharacterDetails> characterDetails = jpaApi.em().createQuery(sql, CharacterDetails.class).getResultList();

        return ok(views.html.characterdetails.render(characterDetails));
    }

    @Transactional
    public void deleteCharacter(int characterId)
    {
        String characterSQL = "SELECT c from GameCharacter c WHERE characterId = :characterId";
        GameCharacter gameCharacter = jpaApi.em().createQuery(characterSQL, GameCharacter.class).setParameter("characterId", characterId).getSingleResult();
        jpaApi.em().remove(gameCharacter);


    }

    @Transactional
    public Result getEditCharacter(int characterId)
    {
        String characterSQL = "SELECT c from GameCharacter c WHERE characterId = :characterId";
        GameCharacter gameCharacter = jpaApi.em().createQuery(characterSQL, GameCharacter.class).setParameter("characterId", characterId).getSingleResult();

        String nextCharacterIdSQL = "SELECT NEW models.CharacterId(MIN(characterId)) FROM GameCharacter c WHERE characterId > :characterId";
        CharacterId nextCharacterId = jpaApi.em().createQuery(nextCharacterIdSQL, CharacterId.class).setParameter("characterId", characterId).getSingleResult();

        if (nextCharacterId.getId() == null)
        {
            String minCharacterIdSQL = "SELECT NEW models.CharacterId(MIN(characterId)) FROM GameCharacter c";
            nextCharacterId = jpaApi.em().createQuery(minCharacterIdSQL, CharacterId.class).getSingleResult();
        }

        String previousCharacterIdSQL = "SELECT NEW models.CharacterId(MAX(characterId)) FROM GameCharacter c WHERE characterId < :characterId";
        CharacterId previousCharacterId = jpaApi.em().createQuery(previousCharacterIdSQL, CharacterId.class).setParameter("characterId", characterId).getSingleResult();

        if (previousCharacterId.getId() == null)
        {
            String maxCharacterIdSQL = "SELECT NEW models.CharacterId(MAX(characterId)) FROM GameCharacter c";
            previousCharacterId = jpaApi.em().createQuery(maxCharacterIdSQL, CharacterId.class).getSingleResult();
        }

        String raceSQL = "SELECT r FROM Race r ORDER BY raceName";
        List<Race> races = jpaApi.em().createQuery(raceSQL, Race.class).getResultList();

        String classSQL = "SELECT ct FROM ClassType ct ORDER BY classTypeName";
        List<ClassType> classTypes = jpaApi.em().createQuery(classSQL, ClassType.class).getResultList();

        String backgroundSQL = "SELECT b FROM Background b ORDER BY backgroundName";
        List<Background> backgrounds = jpaApi.em().createQuery(backgroundSQL, Background.class).getResultList();

        return ok(views.html.editcharacter.render(gameCharacter, races, classTypes, backgrounds, previousCharacterId.getId(), nextCharacterId.getId()));
    }

    @Transactional
    public Result postEditCharacter(int characterId)
    {
        DynamicForm form = formFactory.form().bindFromRequest();
        String[] postAction = request().body().asFormUrlEncoded().get("EndIt");
        String action = postAction[0];
        if ("Delete".equals(action))
        {
            deleteCharacter(characterId);
            return ok("Deleted");
        }
        else
        {
            String characterSQL = "SELECT c FROM GameCharacter c WHERE characterId = :characterId";
            GameCharacter gameCharacter = jpaApi.em().createQuery(characterSQL, GameCharacter.class).setParameter("characterId", characterId).getSingleResult();

            String characterName = form.get("characterName");
            int level = Integer.parseInt(form.get("level"));
            int raceId = Integer.parseInt(form.get("raceId"));
            int classTypeId = Integer.parseInt(form.get("classTypeId"));
            int hitDice = Integer.parseInt(form.get("hitDice"));
            int backgroundId = Integer.parseInt(form.get("backgroundId"));
            int strength = Integer.parseInt(form.get("strength"));
            int dexterity = Integer.parseInt(form.get("dexterity"));
            int constitution = Integer.parseInt(form.get("constitution"));
            int intelligence = Integer.parseInt(form.get("intelligence"));
            int wisdom = Integer.parseInt(form.get("wisdom"));
            int charisma = Integer.parseInt(form.get("charisma"));
            String acrobaticsCheck = form.get("acrobatics");
            int acrobatics;
            if (acrobaticsCheck == null)
            {
                acrobatics = 0;
            } else
            {
                acrobatics = 1;
            }
            String animalHandlingCheck = form.get("animalHandling");
            int animalHandling;
            if (animalHandlingCheck == null)
            {
                animalHandling = 0;
            } else
            {
                animalHandling = 1;
            }
            String arcanaCheck = form.get("arcana");
            int arcana;
            if (arcanaCheck == null)
            {
                arcana = 0;
            } else
            {
                arcana = 1;
            }
            String athleticsCheck = form.get("athletics");
            int athletics;
            if (athleticsCheck == null)
            {
                athletics = 0;
            } else
            {
                athletics = 1;
            }
            String deceptionCheck = form.get("deception");
            int deception;
            if (deceptionCheck == null)
            {
                deception = 0;
            } else
            {
                deception = 1;
            }
            String historyCheck = form.get("history");
            int history;
            if (historyCheck == null)
            {
                history = 0;
            } else
            {
                history = 1;
            }
            String insightCheck = form.get("insight");
            int insight;
            if (insightCheck == null)
            {
                insight = 0;
            } else
            {
                insight = 1;
            }
            String intimidationCheck = form.get("intimidation");
            int intimidation;
            if (intimidationCheck == null)
            {
                intimidation = 0;
            } else
            {
                intimidation = 1;
            }
            String investigationCheck = form.get("investigation");
            int investigation;
            if (investigationCheck == null)
            {
                investigation = 0;
            } else
            {
                investigation = 1;
            }
            String medicineCheck = form.get("medicine");
            int medicine;
            if (medicineCheck == null)
            {
                medicine = 0;
            } else
            {
                medicine = 1;
            }
            String natureCheck = form.get("nature");
            int nature;
            if (natureCheck == null)
            {
                nature = 0;
            } else
            {
                nature = 1;
            }
            String perceptionCheck = form.get("perception");
            int perception;
            if (perceptionCheck == null)
            {
                perception = 0;
            } else
            {
                perception = 1;
            }
            String performanceCheck = form.get("performance");
            int performance;
            if (performanceCheck == null)
            {
                performance = 0;
            } else
            {
                performance = 1;
            }
            String persuasionCheck = form.get("persuasion");
            int persuasion;
            if (persuasionCheck == null)
            {
                persuasion = 0;
            } else
            {
                persuasion = 1;
            }
            String religionCheck = form.get("religion");
            int religion;
            if (religionCheck == null)
            {
                religion = 0;
            } else
            {
                religion = 1;
            }
            String sleightOfHandCheck = form.get("sleightOfHand");
            int sleightOfHand;
            if (sleightOfHandCheck == null)
            {
                sleightOfHand = 0;
            } else
            {
                sleightOfHand = 1;
            }
            String stealthCheck = form.get("stealth");
            int stealth;
            if (stealthCheck == null)
            {
                stealth = 0;
            } else
            {
                stealth = 1;
            }
            String survivalCheck = form.get("survival");
            int survival;
            if (survivalCheck == null)
            {
                survival = 0;
            } else
            {
                survival = 1;
            }

            gameCharacter.setCharacterName(characterName);
            gameCharacter.setLevel(level);
            gameCharacter.setRaceId(raceId);
            gameCharacter.setClassTypeId(classTypeId);
            gameCharacter.setHitDice(hitDice);
            gameCharacter.setBackgroundId(backgroundId);
            gameCharacter.setStrength(strength);
            gameCharacter.setDexterity(dexterity);
            gameCharacter.setConstitution(constitution);
            gameCharacter.setIntelligence(intelligence);
            gameCharacter.setWisdom(wisdom);
            gameCharacter.setCharisma(charisma);
            gameCharacter.setAcrobatics(acrobatics);
            gameCharacter.setAnimalHandling(animalHandling);
            gameCharacter.setArcana(arcana);
            gameCharacter.setAthletics(athletics);
            gameCharacter.setDeception(deception);
            gameCharacter.setHistory(history);
            gameCharacter.setInsight(insight);
            gameCharacter.setIntimidation(intimidation);
            gameCharacter.setInvestigation(investigation);
            gameCharacter.setMedicine(medicine);
            gameCharacter.setNature(nature);
            gameCharacter.setPerception(perception);
            gameCharacter.setPerformance(performance);
            gameCharacter.setPersuasion(persuasion);
            gameCharacter.setReligion(religion);
            gameCharacter.setSleightOfHand(sleightOfHand);
            gameCharacter.setStealth(stealth);
            gameCharacter.setSurvival(survival);

            return ok("Saved");
        }
    }
}
