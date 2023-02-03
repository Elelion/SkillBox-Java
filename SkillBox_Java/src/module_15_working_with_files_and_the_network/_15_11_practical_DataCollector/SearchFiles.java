package module_15_working_with_files_and_the_network._15_11_practical_DataCollector;

import java.io.File;
import java.util.List;

public class SearchFiles {

    /**
     * rootFile - корневая папка для поиска
     * - список куда будут добавляться найденные файлы
     *
     * для более удобного восприятия, ниже приведенный код НЕ разноситься по
     * методам, и имеет 4 вложенности, что не есть хорошо!!!
     */
    public void searchFiles(File rootFile, List<File> fileList) {
        if (rootFile.isDirectory()) {
            // для отображения папкок по которым мы проходимся
//            System.out.println("searching at: " + rootFile);

            File[] directoryFiles = rootFile.listFiles();

            if (directoryFiles != null) {
                for (File file : directoryFiles) {

                    /**
                     * если наш файл является папкой, то ф-ция вызывает саму
                     * себя (рекурсия). Для того что бы поискать в этой
                     * под папке
                     * те мы с каждой папкой делаем одну и ту же операцию
                     * идем во внутрь, находм файлы и заносим их в fileList
                     */
                    if (file.isDirectory()) {
                        searchFiles(file, fileList);
                    } else {
                        /**
                         * если файл соответствует нашему условию, то мы
                         * добавляем этот файл в наш список найденных файлов
                         */
                        if (isExtensionsFile(file)) {
                            fileList.add(file);
                        }
                    }
                }
            }
        }
    }

    private boolean isExtensionsFile(File file) {
        if (file.getName().toLowerCase().endsWith(".json") ||
            file.getName().toLowerCase().endsWith(".csv"))
        {
            return true;
        }

        return false;
    }
}
