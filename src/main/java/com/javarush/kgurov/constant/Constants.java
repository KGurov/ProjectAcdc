package com.javarush.kgurov.constant;

public final class Constants {
    public static String textForProlog = """
               Ты стоишь в космическом порту и готов подняться на борт <br>
               своего корабля. Разве ты не об этом мечтал? Стать капитаном <br>
               галактического судна с экипажем, который будет совершать<br>
               подвиги под твоим командованием.<br>
               Так что вперед!
            """;
    public static String teamMeetUp = """
            Когда ты поднялся на борт корабля, тебя поприветствовала девушка с черной папкой в руках: <br>
            - Здравствуйте, командир! Я Зинаида - ваша помощница. Видите? Так в углу пьет кофе штурман сержант<br>
            Перегарный Шлейф, под штурвалом спит наш бортмеханик- Черный Богдан, <br>
            а фотографирует его Сергей Стальная Пятка на навигатор. <br>
            А как обращаться к вам?
            """;
    public static final String URL_PATTERN = "/start";
    public static final String START_SERVLET = "StartServlet";
    public static final String ADDRESS_ATTRIBUTE = "address";
    public static final String NAME_ATTRIBUTE = "name";
    public static final String ID_ATTRIBUTE = "id";
    public static final String SCORE_ATTRIBUTE = "score";
    public static final String START_PAGE_PATH = "WEB-INF/start.jsp";
    public static final String VIEW_LOSE_JSP = "WEB-INF/lose.jsp";
    public static final String HOME_REDIRECT_URL = "/start";
    public static final String QUEST_PAGE_PATH = "WEB-INF/quest.jsp";
    public static final String QUEST_REDIRECT_URL = "/quest";
    public static final String WIN_REDIRECT_URL = "/win";
    public static final String LOSE_REDIRECT_URL = "/lose";
    public static final String ANSWER_PARAMETER = "answer";
    public static final String WIN_PAGE_PATH = "WEB-INF/win.jsp";
}
