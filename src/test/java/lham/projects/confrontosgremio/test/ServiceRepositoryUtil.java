package lham.projects.confrontosgremio.test;

import java.lang.reflect.Field;

import lham.projects.confrontosgremio.infra.IRepository;
import lham.projects.confrontosgremio.infra.IService;
import lham.projects.confrontosgremio.infra.Persistencia;

/**
 * Classe responsável por inicializar as variáveis injetadas pelo <i>CDI</i> nas
 * classes de serviço e repositório.
 * 
 * @author Luiz Henrique A. Mello
 * 
 */
public class ServiceRepositoryUtil {

    /**
     * Inicializa a classe de persistencia (que contém o {@code EntityManager})
     * de um repositório através de <i>Reflection</i>.
     * 
     * @param repository
     *            objeto repositório que estende a interface {@code IRepository}
     *            .
     * 
     * @param persistencia
     *            objeto da classe {@code Persistencia} que será setado no
     *            repositório.
     */
    public static void inicializarPersistenciaDoRepositorio(IRepository repository, Persistencia persistencia) {
        definirAtributoDoObjeto(repository, persistencia, "persistencia");
    }

    /**
     * Inicialia um atributo do tipo {@code IRepository} em uma classe de
     * serviço através de <i>Reflection</i>.
     * 
     * @param service
     *            objeto serviço que estende a interface {@code IService}.
     * 
     * @param repository
     *            repositório que será setado na classe de serviço.
     * 
     * @param nomeAtributo
     *            nome do atributo do repositório na classe de serviço. Neste
     *            atributo que será atribuído o objeto repositório.
     */
    public static void inicializarRepositoryDoService(IService service, IRepository repository, String nomeAtributo) {
        definirAtributoDoObjeto(service, repository, nomeAtributo);
    }

    /**
     * Recebe um objeto e seta um valor em um atributo deste objeto.
     * 
     * @param objeto
     *            objeto que será setado um valor.
     * 
     * @param valor
     *            valor setado no objeto.
     * 
     * @param nomeAtributo
     *            nome do atributo ao qual o valor é setado.
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
