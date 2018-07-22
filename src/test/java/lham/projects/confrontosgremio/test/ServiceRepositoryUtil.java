package lham.projects.confrontosgremio.test;

import java.lang.reflect.Field;

import lham.projects.confrontosgremio.infra.IRepository;
import lham.projects.confrontosgremio.infra.IService;
import lham.projects.confrontosgremio.infra.Persistencia;

/**
 * Classe respons�vel por inicializar as vari�veis injetadas pelo <i>CDI</i> nas
 * classes de servi�o e reposit�rio.
 * 
 * @author Luiz Henrique A. Mello
 * 
 */
public class ServiceRepositoryUtil {

    /**
     * Inicializa a classe de persistencia (que cont�m o {@code EntityManager})
     * de um reposit�rio atrav�s de <i>Reflection</i>.
     * 
     * @param repository
     *            objeto reposit�rio que estende a interface {@code IRepository}
     *            .
     * 
     * @param persistencia
     *            objeto da classe {@code Persistencia} que ser� setado no
     *            reposit�rio.
     */
    public static void inicializarPersistenciaDoRepositorio(IRepository repository, Persistencia persistencia) {
        definirAtributoDoObjeto(repository, persistencia, "persistencia");
    }

    /**
     * Inicialia um atributo do tipo {@code IRepository} em uma classe de
     * servi�o atrav�s de <i>Reflection</i>.
     * 
     * @param service
     *            objeto servi�o que estende a interface {@code IService}.
     * 
     * @param repository
     *            reposit�rio que ser� setado na classe de servi�o.
     * 
     * @param nomeAtributo
     *            nome do atributo do reposit�rio na classe de servi�o. Neste
     *            atributo que ser� atribu�do o objeto reposit�rio.
     */
    public static void inicializarRepositoryDoService(IService service, IRepository repository, String nomeAtributo) {
        definirAtributoDoObjeto(service, repository, nomeAtributo);
    }

    /**
     * Recebe um objeto e seta um valor em um atributo deste objeto.
     * 
     * @param objeto
     *            objeto que ser� setado um valor.
     * 
     * @param valor
     *            valor setado no objeto.
     * 
     * @param nomeAtributo
     *            nome do atributo ao qual o valor � setado.
     */
    @SuppressWarnings("rawtypes")
    private static void definirAtributoDoObjeto(Object objeto, Object valor, String nomeAtributo) {
        Class clazz = objeto.getClass();
        Field field;

        try {
            field = clazz.getDeclaredField(nomeAtributo);
            field.setAccessible(true);
            field.set(objeto, valor);
        } catch (NoSuchFieldException | SecurityException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
