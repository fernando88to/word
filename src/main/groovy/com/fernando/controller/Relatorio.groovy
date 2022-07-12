package com.fernando.controller

import com.deepoove.poi.XWPFTemplate
import com.deepoove.poi.config.Configure
import com.deepoove.poi.data.Pictures
import com.deepoove.poi.plugin.table.LoopRowTableRenderPolicy
import com.fernando.domain.EquipeCorreicao
import com.fernando.domain.Goods
import com.fernando.domain.GrupoItem
import com.fernando.domain.GrupoObservacao
import com.fernando.domain.Grupos
import com.fernando.domain.Labor
import com.fernando.domain.PaymentHackData
import groovy.transform.CompileStatic
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces

import java.nio.file.Files

@CompileStatic
@Controller('/relatorio')
class Relatorio {





    private String textoGrande() {
        String texto = 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean vitae libero viverra, luctus nulla ac, sagittis odio. Curabitur nec sollicitudin enim, fermentum volutpat erat. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Sed eget varius tortor. In vulputate nulla arcu, id tristique nulla tincidunt non. Phasellus semper fringilla placerat. Morbi quis lorem ex. In dapibus nisi ac finibus ultricies. Nunc ut sapien at libero tempor ullamcorper. Duis tortor nulla, congue eget sem et, hendrerit imperdiet purus. Suspendisse et turpis in tellus elementum vulputate ac ac nibh. Vivamus aliquam ultrices neque, consectetur volutpat arcu placerat et. Nunc sollicitudin, sem ut semper interdum, justo turpis condimentum lorem, vel elementum nulla ex non libero. Nulla dapibus, lacus maximus ultricies tristique, ex sapien dignissim massa, in ornare felis leo sed libero. Curabitur eu pharetra est.'
        texto += texto

        return texto
    }

    private String base64Imagem() {
        File file = new File("47f775ae86724becd9e83d4f7fe1d5d5.jpg");
        try {
            byte[] fileContent = Files.readAllBytes(file.toPath())
            return Base64.getEncoder().encodeToString(fileContent)
        } catch (IOException e) {
            throw new IllegalStateException("could not read file " + file, e);
        }

    }


    //https://github.com/Sayi/poi-tl/blob/master/poi-tl/src/test/java/com/deepoove/poi/tl/plugin/HackLoopTableRenderPolicyTest.java
    @Get(uri = '/termo2')
    @Produces(MediaType.TEXT_PLAIN)
    String index2() {
        LoopRowTableRenderPolicy hackLoopTableRenderPolicy = new LoopRowTableRenderPolicy();
        LoopRowTableRenderPolicy hackLoopSameLineTableRenderPolicy = new LoopRowTableRenderPolicy(true);
        Configure config = Configure.builder()
                .bind("goods", hackLoopTableRenderPolicy)
                .bind("equipe", hackLoopTableRenderPolicy)
                .bind("grupoItens", hackLoopTableRenderPolicy)
                //.bind("grupos", hackLoopTableRenderPolicy)
                .bind("labors", hackLoopTableRenderPolicy)
                .bind("goods2", hackLoopSameLineTableRenderPolicy)
                .bind("labors2", hackLoopSameLineTableRenderPolicy).build();
        XWPFTemplate template = XWPFTemplate.compile("render_hackloop.docx", config).render(getData());
        template.writeToFile("out_render_looprow.docx");

        //PdfOptions options = PdfOptions.create()
        //PdfConverter.getInstance().convert(template.getXWPFDocument(), new FileOutputStream("termo_correicao.pdf"), options)
        return "oi2";

    }

    private PaymentHackData getData(){
        PaymentHackData data = new PaymentHackData();
        data.comarca = "WANDERLÂNDIA"
        data.cidade = "DARCINOPOLIS"
        data.nomeCartorio = "ÚNICO SERVIÇO NOTARIAL E REGISTRAL COM ATRIBUIÇÕES ESPECIALIZADAS DE TABELIONATO DE NOTAS, TABELIONADO DE PROTESTO DE TÍTULOS, REGISTRO DE IMÓVEIS, REGISTRO DE TÍTULOS E DOCUMENTOS, REGISTRO CIVIL DAS PESSOAS JURÍDICAS, E REGISTRO CIVIL DAS PESSOAS NATURAIS E DE INTERDIÇÃO E TUTELAS"
        data.atoNomeacao = 'Diário 229 Número 302 publicado em 04/04/1994'
        data.dataNomeacao = '04/04/1994'
        data.corregedor = ''
        data.dataCorreicao = '05/07/2022'


        List<Goods> goods = new ArrayList<>();
        Goods good = new Goods();
        good.setCount(4);
        good.setNome("Wagner José dos Santos");
        good.setFuncao("Coordenador dos Serviços Notariais e de Registro");
        good.setDiscount(1500);
        good.setPrice(400);
        good.setTax(new Random().nextInt(10) + 20);
        good.setTotalPrice(1600);
        //good.setPicture(Pictures.ofLocal("src/test/resources/earth.png").size(24, 24).create());
        good.setPicture(Pictures.ofLocal("earth.png").size(24, 24).create());
        goods.add(good);
        goods.add(good);
        goods.add(good);
        data.setGoods(goods);

        List<Labor> labors = new ArrayList<>();
        Labor labor = new Labor();
        labor.setCategory("油漆工");
        labor.setPeople(2);
        labor.setPrice(400);
        labor.setTotalPrice(1600);
        labors.add(labor);
        labors.add(labor);
        labors.add(labor);
        data.setLabors(labors);

        data.setTotal("1024");


        data.setGoods2(goods);
        data.setLabors2(labors);
        List<EquipeCorreicao> equipe = []
        equipe.add(new EquipeCorreicao(nome:'Wagner José dos Santos',funcao:'Coordenador dos Serviços Notariais e de Registro'))
        equipe.add(new EquipeCorreicao(nome:'Carla Rejany Pimenta de Andrade',funcao:'Assessor(a) Jurídico(a) de 1ª Instância'))
        equipe.add(new EquipeCorreicao(nome:'ETELVINA MARIA SAMPAIO FELIPE',funcao:'Corregedora-Geral da Justiça'))
        equipe.add(new EquipeCorreicao(nome:'Joyce Coelho Nogueira',funcao:'Assessora Correcional da Corregedoria-Geral da Justiça'))
        equipe.add(new EquipeCorreicao(nome:'Ludiana Costa',funcao:'Assessora Correcional da Corregedoria-Geral da Justiça'))

        List<Grupos> grupos  = []

        def grupoDeclaracaoDados = new Grupos(nome:'Declaração de Dados', grupoItens:[])

        def item1 = new GrupoItem(numero:1, texto:'Alimentação do Sistema Justiça Aberta', valor:'Irregular', grupoObservacaos:[])
        def item2 = new GrupoItem(numero:2, texto:'Tabela de Custas e Emolumentos', valor:'', grupoObservacaos:[])
        def item3 = new GrupoItem(numero:2, texto:'GISE - Comunica não lidos 24h após o recebimento (6 meses)', valor:'53', grupoObservacaos:[])

        item1.grupoObservacaos.add(new GrupoObservacao(texto:'A matrículo do imóvel n. 3000', tipo:'Determinação'))

        grupoDeclaracaoDados.grupoItens.add(item1)
        grupoDeclaracaoDados.grupoItens.add(item2)
        grupoDeclaracaoDados.grupoItens.add(item3)


        grupos.add(grupoDeclaracaoDados)
        //grupos.add(new Grupos(nome:'Tributos (Débitos)'))
        //grupos.add(new Grupos(nome:'Metas e Provimentos da Corregedoria Nacional de Justiça'))
        data.setGrupos(grupos)
        data.setEquipe(equipe)
        return  data

    }
}
