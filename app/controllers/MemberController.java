package controllers;

import models.Chapter;
import models.Member;
import models.MemberDetail;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class MemberController extends Controller
{
    private final JPAApi jpaApi;
    private final FormFactory formFactory;

    @Inject
    public MemberController(JPAApi jpaApi, FormFactory formFactory)
    {
        this.jpaApi = jpaApi;
        this.formFactory = formFactory;
    }

    @Transactional
    public Result renderAddMember()
    {
        List<Chapter> chapters = jpaApi.em().createQuery("SELECT c FROM Chapter c", Chapter.class).getResultList();

        return ok(views.html.addMember.render(chapters));
    }

    @Transactional
    public Result addMember()
    {
        DynamicForm form = formFactory.form().bindFromRequest();

        String firstName = form.get("firstName");
        String lastName = form.get("lastName");
        String email = form.get("email");
        String phone = form.get("phone");
        String company = form.get("company");
        String job = form.get("job");
        String joinDate = form.get("joinDate");
        int chapter = Integer.parseInt(form.get("chapter"));
        String volunteer = form.get("volunteer");

        Member member = new Member();

        member.setFirstName(firstName);
        member.setLastName(lastName);
        member.setEmail(email);
        member.setPhone(Long.parseLong(phone));
        member.setEmail(email);
        member.setJobTitleID(1);
        member.setCompanyID(1);
        member.setChapterID(chapter);
        //TODO: check if job/company exists then set accordingly
        //TODO: format join date as date and set accordingly
        member.setVolunteer(Integer.parseInt(volunteer));

        jpaApi.em().persist(member);

        return redirect(routes.BaseController.index());
    }

    @Transactional
    public Result renderEditMember(Integer id)
    {
        String query = "SELECT m.member_id as id, m.first_name as firstName, m.last_name as lastName, m.email, m.phone, ch.name as chapter, m.date_joined as dateJoined, m.volunteer, co.name as company, jt.name as jobTitle FROM member m  JOIN company co ON m.company_id = co.company_id  JOIN chapter ch ON m.chapter_id = ch.chapter_id JOIN job_title jt ON m.job_title_id = jt.job_title_id WHERE m.member_id = :id";

        MemberDetail member = (MemberDetail) jpaApi.em()
                .createNativeQuery(query, MemberDetail.class)
                .setParameter("id", id)
                .getSingleResult();

        List<Chapter> chapters = jpaApi.em().createQuery("SELECT c FROM Chapter c", Chapter.class).getResultList();

        return ok(views.html.editMember.render(member, chapters));
    }

    @Transactional
    public Result editMember(Integer id)
    {

        return ok();
    }
}
