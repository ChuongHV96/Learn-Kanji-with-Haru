package prm3101.group_assignment.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import prm3101.group_assignment.R;
import prm3101.group_assignment.adapter.GridAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HiraFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HiraFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HiraFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    String hiraganaList[] = { "あ","い","う","え","お","か","き","く","け",
            "こ","さ","し","す","せ","そ","た","ち","つ",
            "て","と","な","に","ぬ","ね","の","は","ひ","ふ","へ","ほ",
            "ま","み","む","め","も","や","ゆ","よ","ら",
            "り","る","れ","ろ","わ","を","ん" };
    String romajiList[] = { "a","i","u","e","o","ka","ki","ku","ke","ko",
            "sa","shi","su","se","so","ta","chi","tsu","te","to",
            "na","ni","nu","ne","no","ha","hi","fu","he","ho",
            "ma","mi","mu","me","mo","ya","yu","yo",
            "ra","ri","ru","re","ro","wa","wo","n" };

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public HiraFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HiraFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HiraFragment newInstance(String param1, String param2) {
        HiraFragment fragment = new HiraFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View frag1 = inflater.inflate(R.layout.fragment_tab_fragment1, container, false);
        GridView mGridView = (GridView) frag1.findViewById(R.id.gridView);
        GridAdapter adapter = new GridAdapter(hiraganaList, romajiList, getActivity().getApplicationContext());
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),
//                android.R.layout.simple_list_item_1, hiraganaList);
        mGridView.setAdapter(adapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Add detail - To do later
            }
        });
        return frag1;
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}