package Tilbakemelding;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Feedback.class)
public abstract class Feedback_ {

	public static volatile SingularAttribute<Feedback, String> loginUser;
	public static volatile SingularAttribute<Feedback, String> rating;
	public static volatile SingularAttribute<Feedback, String> comment;
	public static volatile SingularAttribute<Feedback, Integer> FeedbackId;

}

