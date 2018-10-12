package controllers;

import models.CharacterDetails;
import models.GameCharacter;
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
    public Result getCharacter(int characterId)
    {
        String sql = "SELECT c FROM GameCharacter c WHERE characterId = :characterId";

        GameCharacter gameCharacter = jpaApi.em().createQuery(sql, GameCharacter.class).setParameter("characterId", characterId).getSingleResult();

        return ok(views.html.character.render(gameCharacter));
    }

    @Transactional (readOnly = true)
    public Result getCharacterDetails()
    {
        String sql = "SELECT NEW models.CharacterDetails() " +
                     "FROM Character c JOIN Race r ON c.raceId = r.raceId " +
                     "LEFT OUTER JOIN ClassType ct ON c.classTypeId = ct.classTypeId " +
                     "LEFT OUTER JOIN Background b ON c.backgroundId = b.backgroundId";

        List<CharacterDetails> characterDetails = jpaApi.em().createQuery(sql, CharacterDetails.class).getResultList();

        return ok(views.html.characterdetails.render(characterDetails));
    }
}
