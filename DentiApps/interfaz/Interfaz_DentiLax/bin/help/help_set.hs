<helpset version="1.0">
    <title>MANUAL DENTIAPP</title>
    <maps>
        <homeID>principal</homeID>
        <mapref location="mapa.jhm"/>
    </maps>

    <view>
        <name>Tabla de Contenidos</name>
        <label>Tabla de Contenidos</label>
        <type>javax.help.TOCView</type>
        <data>toc.xml</data>
    </view>
    <view>
        <name>Indice</name>
        <label>Indice</label>
        <type>javax.help.IndexView</type>
        <data>indice.xml</data>
    </view>
    <view>
        <name>Buscar</name>
        <label>Buscar</label>
        <type>javax.help.SearchView</type>
        <data engine="com.sun.java.help.search.DefaultSearchEngine">Java Help</data>
    </view>

</helpset>