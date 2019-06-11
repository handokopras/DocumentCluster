/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testCluster;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Cluster;
import model.Document;
import model.InvertedIndex;
import model.Posting;

/**
 *
 * @author admin
 */
public class TestCluster1 {

    public static void main(String[] args) {
        // buat object invertedIndex
        InvertedIndex index = new InvertedIndex();
        File file = new File("G:\\ClusterDoc\\Document");
        index.readDirectory(file);
        JOptionPane.showMessageDialog(null, "Documents Opened");
// bikin dictionary
        index.makeDictionaryWithTermNumber();
// bikin preclustering
        index.preClustering();
        for (int i = 0; i < index.getListOfDocument().size(); i++) {
            ArrayList<Posting> listPosting
                    = index.getListOfDocument().get(i).getListOfClusteringPosting();
            System.out.println("IdDoc = " + index.getListOfDocument().get(i).getId());
            for (int j = 0; j < listPosting.size(); j++) {
                System.out.println(listPosting.get(j));
            }

        }
        index.clustering();
        for (int i = 0; i < index.getListOfCluster().size(); i++) {
            Cluster cluster = index.getListOfCluster().get(i);
            System.out.println("cluster : " + cluster.getIdCluster());
            System.out.println("Member : ");
            for (int j = 0; j < cluster.getMember().size(); j++) {
                System.out.println(cluster.getMember().get(j).getId());
            }
            System.out.println("");
        }
    }
}
